package site.zqiusu.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, Long> extends PagingAndSortingRepository<T, Long> {
    //查询前三条记录(更新时间倒序，id顺序)
    List<T> findTop3ByOrderByUpdateTimeDescIdAsc();
}
