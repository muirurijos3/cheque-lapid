package com.ke.chequelapid.specification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.criteria.Predicate;

import com.ke.chequelapid.domain.Cheque;
import com.ke.chequelapid.domain.ChequeStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class ChequeSpecification {
    public static Specification<Cheque> chequeDraweeContainsIgnoreCase(String searchTerm){
        return (root, query, cb) -> {
            Predicate p = cb.disjunction();
            p.getExpressions().add(cb.like(cb.lower(root.get("drawee")), "%" + searchTerm + "%"));
            return p;
        };
    }

    public static Specification<Cheque> isChequeOpen(){
        return (root, query, cb) -> cb.equal(root.get("status"), ChequeStatus.OPEN);
    }

    public static Specification<Cheque> findChequeByParams(
            String bank,
            String customer,
            String datecreated,
            String dateOfDeposit){

        return (root, query, criteriaBuilder)->{
            final Collection<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(bank)) {
                final Predicate bankPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("bank")), "%"+bank+"%");
            }
            if (!StringUtils.isEmpty(customer)) {
                final Predicate customerPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("customer")), "%"+customer+"%");
            }
            if (!StringUtils.isEmpty(datecreated)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = sdf.parse(datecreated);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                LocalDate localDateCreated = convertToLocalDate(date);
                final Predicate dateCreatedPredicate = criteriaBuilder.equal(root.get("dateModified"), localDateCreated);
                predicates.add(dateCreatedPredicate);
            }
            if (!StringUtils.isEmpty(dateOfDeposit)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = sdf.parse(dateOfDeposit);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                LocalDate localDateOfDeposit = convertToLocalDate(date);
                final Predicate dateOfDepositPredicate = criteriaBuilder.equal(root.get("dateOfDeposit"), localDateOfDeposit);
                predicates.add(dateOfDepositPredicate);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
