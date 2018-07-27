package ru.pearx.customwhitelist.sync;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLException;
import java.util.List;

/*
 * Created by mrAppleXZ on 26.07.18.
 */
public enum SyncMethod
{
    HTTP
            {
                @Override
                public List<WhitelistEntry> synchronize()
                {
                    throw new NotImplementedException();
                }
            },
    JDBC
            {
                @Override
                public List<WhitelistEntry> synchronize() throws SQLException
                {
                    throw new NotImplementedException();
                }
            };


    public abstract List<WhitelistEntry> synchronize() throws Exception;
}
