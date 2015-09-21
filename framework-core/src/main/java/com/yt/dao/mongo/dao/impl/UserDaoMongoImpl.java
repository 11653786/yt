package com.yt.dao.mongo.dao.impl;

import com.yt.dao.mongo.dao.UserDaoMongo;
import com.yt.dao.mongo.impl.MongoDaoImpl;
import com.yt.entity.mongo.UserMongo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 2015/9/21.
 */
@Repository
@Transactional
public class UserDaoMongoImpl extends MongoDaoImpl<UserMongo> implements UserDaoMongo {
}
