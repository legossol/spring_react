package shop.philoarte.api.funding.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shop.philoarte.api.funding.domain.Funding;

public interface SearchFundingRepository {
    Funding search();

        Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
