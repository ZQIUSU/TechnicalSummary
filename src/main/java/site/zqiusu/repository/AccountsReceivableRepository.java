package site.zqiusu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import site.zqiusu.dto.AccountsReceivableDTO;
import site.zqiusu.model.AccountsReceivable;

import java.util.List;
import java.util.Objects;

public interface AccountsReceivableRepository extends JpaRepository<AccountsReceivable,Long> {
    @Query("SELECT agingAnalysis, SUM(receivableAmount) " +
            "FROM AccountsReceivable " +
            "GROUP BY agingAnalysis " +
            "ORDER BY agingAnalysis")
    List<Object[]> sumReceivableAmountGroupByAgingAnalysis();
}
