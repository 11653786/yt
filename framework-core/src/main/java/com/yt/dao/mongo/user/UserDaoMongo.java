package com.yt.dao.mongo.user;

import com.mongodb.BasicDBObject;
import com.yt.dao.mongo.MongoDao;
import com.yt.entity.mongo.UserMongo;

import java.util.List;

/**
 * Created by user on 2015/9/21.
 */
public interface UserDaoMongo extends MongoDao<UserMongo>{

    public List<UserMongo> getlist(BasicDBObject where);

}
