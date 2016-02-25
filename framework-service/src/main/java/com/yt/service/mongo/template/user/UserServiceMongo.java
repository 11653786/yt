package com.yt.service.mongo.template.user;

import com.mongodb.BasicDBObject;
import com.yt.dao.base.mongo.base.MongoDao;
import com.yt.entity.mongo.UserMongo;

import java.util.List;

/**
 * Created by user on 2015/9/21.
 */
public interface UserServiceMongo extends MongoDao<UserMongo>{

    public List<UserMongo> getlist(BasicDBObject where);

}
