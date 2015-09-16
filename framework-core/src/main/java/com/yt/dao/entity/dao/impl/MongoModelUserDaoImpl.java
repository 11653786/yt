package com.yt.dao.entity.dao.impl;

import com.yt.dao.base.mongo.impl.MongoDaoImpl;
import com.yt.dao.entity.dao.MongoModelUserDao;
import com.yt.entity.mongodb.ModelMongo;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by user on 2015/9/16.
 */
@Repository
@Transactional
public class MongoModelUserDaoImpl extends MongoDaoImpl<ModelMongo> implements MongoModelUserDao {
}
