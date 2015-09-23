package com.yt.dao.mongo.dao.impl;

import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.yt.dao.mongo.dao.UserDaoMongo;
import com.yt.dao.mongo.impl.MongoDaoImpl;
import com.yt.entity.mongo.UserMongo;
import com.yt.util.JsonUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 2015/9/21.
 */
@Repository
@Transactional
public class UserDaoMongoImpl extends MongoDaoImpl<UserMongo> implements UserDaoMongo {

    public List<UserMongo> getlist(BasicDBObject where) {
        DBCursor sql= super.getDbCollection().find(where);
        List<DBObject> list=sql.toArray();
        String str= JsonUtil.toJson(list);
        List<UserMongo>  retList =  JsonUtil.fromJson(str, new TypeToken<List<UserMongo>>() {}.getType());
        return retList;
    }


}
