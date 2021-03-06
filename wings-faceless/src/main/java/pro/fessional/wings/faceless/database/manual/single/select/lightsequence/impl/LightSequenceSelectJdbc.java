package pro.fessional.wings.faceless.database.manual.single.select.lightsequence.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pro.fessional.wings.faceless.database.manual.single.select.lightsequence.LightSequenceSelect;

import java.util.List;
import java.util.Optional;


/**
 * @author trydofor
 * @since 2019-06-03
 */
@RequiredArgsConstructor
public class LightSequenceSelectJdbc implements LightSequenceSelect {

    private final JdbcTemplate jdbcTemplate;
    private final String selectOne;
    private final String selectAll;

    private final RowMapper<NextStep> mapperNextStep = (rs, rowNum) -> {
        NextStep one = new NextStep();
        one.setNextVal(rs.getLong("next_val"));
        one.setStepVal(rs.getInt("step_val"));
        return one;
    };

    @Override
    public Optional<NextStep> selectOneLock(int block, String name) {
        List<NextStep> list = jdbcTemplate.query(selectOne, mapperNextStep, block, name);
        int size = list.size();
        if (size == 0) {
            return Optional.empty();
        } else if (size == 1) {
            return Optional.of(list.get(0));
        } else {
            throw new IllegalStateException("find " + size + " records, block=" + block + ", name=" + name);
        }
    }

    private final RowMapper<NameNextStep> mapperNameNextStep = (rs, rowNum) -> {
        NameNextStep one = new NameNextStep();
        one.setSeqName(rs.getString("seq_name"));
        one.setStepVal(rs.getInt("step_val"));
        one.setStepVal(rs.getInt("step_val"));
        return one;
    };

    @Override
    public List<NameNextStep> selectAllLock(int block) {
        return jdbcTemplate.query(selectAll, mapperNameNextStep, block);
    }
}
