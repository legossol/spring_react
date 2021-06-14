package shop.philoarte.api.funding.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import shop.philoarte.api.artist.domain.QArtist;
import shop.philoarte.api.funding.domain.Funding;
import shop.philoarte.api.funding.domain.QFunding;
import shop.philoarte.api.funding.domain.QFundingFile;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class SearchFundingRepositoryImpl extends QuerydslRepositorySupport implements SearchFundingRepository {

    public SearchFundingRepositoryImpl(){
        super(Funding.class);
    }


    @Override
    public Funding search() {
        QFunding funding = QFunding.funding;
        QArtist artist = QArtist.artist;
        QFundingFile fundingFile = QFundingFile.fundingFile;

        JPQLQuery<Funding> jpqlQuery = from(funding);
        jpqlQuery.leftJoin(artist).on(funding.artist.eq(artist));
        jpqlQuery.leftJoin(fundingFile).on(fundingFile.funding.eq(funding));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(funding, artist,fundingFile);

        tuple.groupBy(funding);

        List<Tuple> result = tuple.fetch();

        log.info(result);

        return null;
    }

    @Override
    public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
        QFunding funding= QFunding.funding;
        QArtist artist = QArtist.artist;
        QFundingFile fundingFile= QFundingFile.fundingFile;

        JPQLQuery<Funding> jpqlQuery = from(funding);
        jpqlQuery.leftJoin(artist).on(funding.artist.eq(artist));
        jpqlQuery.leftJoin(fundingFile).on(fundingFile.funding.eq(funding));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(funding, artist,fundingFile);

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        BooleanExpression expression = funding.fundingId.gt(0L);

        booleanBuilder.and(expression);

        if(type != null) {
            String[] typeArr = type.split("");

            BooleanBuilder conditionBuilder = new BooleanBuilder();

            for (String t : typeArr) {
                switch (t) {
                    case "u":
                        conditionBuilder.or(artist.username.contains(keyword));
                        break;
                    case "n":
                        conditionBuilder.or(artist.name.contains(keyword));
                        break;
                    case "t":
                        conditionBuilder.or(funding.title.contains(keyword));
                        break;
                    case "c":
                        conditionBuilder.or(funding.content.contains(keyword));
                        break;
                }
            }
            booleanBuilder.and(conditionBuilder);
        }
            Sort sort = pageable.getSort();

            sort.stream().forEach(order -> {
                Order direction = order.isAscending() ? Order.ASC: Order.DESC;
                String prop = order.getProperty();

                PathBuilder orderByExpression = new PathBuilder(Funding.class,"funding");
                        tuple.orderBy(new OrderSpecifier(direction, orderByExpression.get(prop)));
            });

            tuple.groupBy(funding);

            List<Tuple> result = tuple.fetch();

            tuple.offset(pageable.getOffset());
            tuple.limit(pageable.getPageSize());

            long count = tuple.fetchCount();

            return new PageImpl<Object[]>(result.stream().map(t->t.toArray()).collect(Collectors.toList()),pageable,count);

    }
}
