package com.haibo.test.service;

import com.haibo.test.mapper.CustomerMapper;
import com.haibo.test.model.domain.Customer;
import com.xdbigdata.framework.service.BaseService;

/**
 * @author XD
 * @date 2018/8/23 11:59
 */
public interface HttpRequestService extends BaseService<Customer, CustomerMapper> {

    void testMain() throws Exception;
}
