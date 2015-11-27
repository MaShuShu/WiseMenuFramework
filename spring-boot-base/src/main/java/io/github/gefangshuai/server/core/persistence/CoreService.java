package io.github.gefangshuai.server.core.persistence;

import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 核心 Service 类
 * Created by gefangshuai on 2015/11/16.
 */
@Transactional(readOnly = true)
public abstract class CoreService<T, ID extends Serializable> {
    protected CoreDao<T, ID> coreDao;

    public T findOne(ID id) {
        return coreDao.findOne(id);
    }

    @Transactional
    public T save(T t) {
        return coreDao.save(t);
    }

    public List<T> findAll() {
        return coreDao.findAll();
    }

    public List<T> findAll(Sort sort) {
        return coreDao.findAll(sort);
    }

    @Transactional
    public void delete(ID id) {
        coreDao.delete(id);
    }
}
