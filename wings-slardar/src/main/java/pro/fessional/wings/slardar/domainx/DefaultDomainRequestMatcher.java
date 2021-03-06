package pro.fessional.wings.slardar.domainx;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import pro.fessional.wings.slardar.servlet.request.WingsRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import static pro.fessional.wings.slardar.servlet.request.ResourceHttpRequestUtil.existResource;

/**
 * @author trydofor
 * @since 2021-02-15
 */
public class DefaultDomainRequestMatcher implements DomainRequestMatcher {

    private final String pathPrefix;
    private final List<HandlerMapping> mappingUrl = new ArrayList<>();
    private final AntPathMatcher antMatcher = new AntPathMatcher();
    private final LinkedHashSet<String> otherUrl = new LinkedHashSet<>();
    private final DispatcherServlet dispatcherServlet;
    private final Cache<String, Boolean> matchedUrl;
    private final Cache<String, Boolean> notfoundUrl;

    public DefaultDomainRequestMatcher(DispatcherServlet dispatcher, String pathPrefix, Collection<String> otherUrl, int cacheSize) {
        this.dispatcherServlet = dispatcher;
        this.pathPrefix = pathPrefix;
        this.otherUrl.addAll(otherUrl);
        this.matchedUrl = Caffeine.newBuilder().maximumSize(cacheSize).build();
        this.notfoundUrl = Caffeine.newBuilder().maximumSize(cacheSize).build();
    }

    @Override
    public HttpServletRequest match(HttpServletRequest request, String domain) {
        checkInitMapping();

        String domainUrl = pathPrefix + domain + request.getRequestURI();
        WingsRequestWrapper wrapper = new WingsRequestWrapper(request)
                .setRequestURI(domainUrl);

        Boolean b = matchedUrl.getIfPresent(domainUrl);
        if (b != null && b) {
            return wrapper;
        }

        for (String u : otherUrl) {
            if (antMatcher.match(u, domainUrl)) {
                matchedUrl.put(domainUrl, Boolean.TRUE);
                return wrapper;
            }
        }

        if (notfoundUrl.getIfPresent(domainUrl) != null) {
            return request;
        }

        //UrlPathHelper.getPathWithinServletMapping
        for (HandlerMapping hm : mappingUrl) {
            try {
                HandlerExecutionChain hdc = hm.getHandler(wrapper);
                if (hdc != null) {
                    Object hd = hdc.getHandler();
                    if (hd instanceof ResourceHttpRequestHandler) {
                        if (existResource((ResourceHttpRequestHandler) hd, wrapper)) {
                            matchedUrl.put(domainUrl, Boolean.TRUE);
                            return wrapper;
                        }
                    } else {
                        matchedUrl.put(domainUrl, Boolean.TRUE);
                        return wrapper;
                    }
                }
            } catch (Exception e) {
                // ignore;
            }
        }

        notfoundUrl.put(domainUrl, Boolean.TRUE);
        return request;
    }

    private volatile boolean initMapping = false;

    private void checkInitMapping() {
        if (initMapping) return;

        synchronized (mappingUrl) {
            if (initMapping) return;
            List<HandlerMapping> mappings = dispatcherServlet.getHandlerMappings();
            if (mappings != null) {
                mappingUrl.addAll(mappings);
                initMapping = true;
            }
        }
    }
}
