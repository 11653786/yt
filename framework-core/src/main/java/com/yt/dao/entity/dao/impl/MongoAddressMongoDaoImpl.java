package com.yt.dao.entity.dao.impl;

import com.yt.dao.base.BaseDao;
import com.yt.dao.base.impl.BaseDaoImpl;
import com.yt.dao.base.mongo.impl.MongoDaoImpl;
import com.yt.dao.entity.dao.MongoAddressMongoDao;
import com.yt.entity.mongodb.AddressMongo;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by user on 2015/9/16.
 */
@Repository
@Transactional
public class MongoAddressMongoDaoImpl extends MongoDaoImpl<AddressMongo> implements MongoAddressMongoDao{
}
