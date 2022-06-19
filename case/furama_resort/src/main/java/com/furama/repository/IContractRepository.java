package com.furama.repository;

import com.furama.model.Contract;
import com.furama.service.ICustomerVipService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract , Long> {
    @Query(value="select customer.customer_id                                                                                customerId,\n" +
            "       customer.customer_name                                                                              customerName,\n" +
            "       customer_type.customer_type_name                                                                    customerTypeName,\n" +
            "       service.service_name                                                                                serviceName,\n" +
            "       contract.contract_start_day                                                                         startDate,\n" +
            "       GROUP_CONCAT(attach_service.attach_service_name)                                                    attachServiceName,\n" +
            "       contract.contract_end_day                                                                           endDate,\n" +
            "       sum((coalesce(contract_detail.quantity * attach_service.attach_service_cost, 0))) + service_cost as total\n" +
            "from contract\n" +
            "         join customer on contract.id_customer_customer_id = customer.customer_id\n" +
            "         left join customer_type on customer.id_customer_type = customer_type.customer_type_id\n" +
            "         left join contract_detail on contract.contract_id = contract_detail.contract_contract_id\n" +
            "         left join service on contract.id_service_service_id = service.service_id\n" +
            "         left join attach_service\n" +
            "                   on contract_detail.id_attach_service_attach_service_id = attach_service.attach_service_id\n" +
            "where contract_start_day between :startst and :endst and  contract_start_day between :started and :ended \n"+
            "group by contract.contract_id",
    countQuery="select customer.customer_id                                                                                customerId,\n" +
            "       customer.customer_name                                                                              customerName,\n" +
            "       customer_type.customer_type_name                                                                    customerTypeName,\n" +
            "       service.service_name                                                                                serviceName,\n" +
            "       contract.contract_start_day                                                                         startDate,\n" +
            "       GROUP_CONCAT(attach_service.attach_service_name)                                                    attachServiceName,\n" +
            "       contract.contract_end_day                                                                           endDate,\n" +
            "       sum((coalesce(contract_detail.quantity * attach_service.attach_service_cost, 0))) + service_cost as total\n" +
            "from contract\n" +
            "         join customer on contract.id_customer_customer_id = customer.customer_id\n" +
            "         left join customer_type on customer.id_customer_type = customer_type.customer_type_id\n" +
            "         left join contract_detail on contract.contract_id = contract_detail.contract_contract_id\n" +
            "         left join service on contract.id_service_service_id = service.service_id\n" +
            "         left join attach_service\n" +
            "                   on contract_detail.id_attach_service_attach_service_id = attach_service.attach_service_id\n" +
            "where contract_start_day between :startst and :endst and  contract_start_day between :started and :ended \n"+

            "group by contract.contract_id", nativeQuery = true)
    List<ICustomerVipService> getCustomerVipList(
            @Param("startst") String startBegin,
            @Param("endst") String startEnd,
            @Param("started") String endBegin,
            @Param("ended") String end
    );

    @Query(value = "select * from  contract where contract_start_day between :start and :end",
            countQuery = "select * from  contract where contract_start_day between :start and :end", nativeQuery = true)
    List<Contract> search(@Param("start") String dayStart, @Param("end") String dayEnd);
}
