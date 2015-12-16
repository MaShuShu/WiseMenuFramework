package io.github.gefangshuai.permission.dao;

import io.github.gefangshuai.server.core.persistence.CoreDao;
import io.github.gefangshuai.permission.model.User;

/**
 * Created by gefangshuai on 2015/11/6.
 */
public interface UserDao extends CoreDao<User, Long> {
    User findByUsername(String username);
}