package wanderingdevelopment.tk.chatsdkcore.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import wanderingdevelopment.tk.chatsdkcore.entities.JoinMessageWithUser.ReadStatus;
import wanderingdevelopment.tk.chatsdkcore.entities.JoinMessageWithUser.ReadStatusConverter;

import wanderingdevelopment.tk.chatsdkcore.entities.JoinMessageWithUser;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "JOIN_MESSAGE_WITH_USER".
*/
public class JoinMessageWithUserDao extends AbstractDao<JoinMessageWithUser, Long> {

    public static final String TABLENAME = "JOIN_MESSAGE_WITH_USER";

    /**
     * Properties of entity JoinMessageWithUser.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ThreadId = new Property(1, Long.class, "threadId", false, "THREAD_ID");
        public final static Property UserId = new Property(2, Long.class, "userId", false, "USER_ID");
        public final static Property ReadStatus = new Property(3, Integer.class, "readStatus", false, "READ_STATUS");
    }

    private final ReadStatusConverter readStatusConverter = new ReadStatusConverter();

    public JoinMessageWithUserDao(DaoConfig config) {
        super(config);
    }
    
    public JoinMessageWithUserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"JOIN_MESSAGE_WITH_USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"THREAD_ID\" INTEGER," + // 1: threadId
                "\"USER_ID\" INTEGER," + // 2: userId
                "\"READ_STATUS\" INTEGER);"); // 3: readStatus
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"JOIN_MESSAGE_WITH_USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, JoinMessageWithUser entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long threadId = entity.getThreadId();
        if (threadId != null) {
            stmt.bindLong(2, threadId);
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(3, userId);
        }
 
        ReadStatus readStatus = entity.getReadStatus();
        if (readStatus != null) {
            stmt.bindLong(4, readStatusConverter.convertToDatabaseValue(readStatus));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, JoinMessageWithUser entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long threadId = entity.getThreadId();
        if (threadId != null) {
            stmt.bindLong(2, threadId);
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(3, userId);
        }
 
        ReadStatus readStatus = entity.getReadStatus();
        if (readStatus != null) {
            stmt.bindLong(4, readStatusConverter.convertToDatabaseValue(readStatus));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public JoinMessageWithUser readEntity(Cursor cursor, int offset) {
        JoinMessageWithUser entity = new JoinMessageWithUser( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // threadId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // userId
            cursor.isNull(offset + 3) ? null : readStatusConverter.convertToEntityProperty(cursor.getInt(offset + 3)) // readStatus
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, JoinMessageWithUser entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setThreadId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setUserId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setReadStatus(cursor.isNull(offset + 3) ? null : readStatusConverter.convertToEntityProperty(cursor.getInt(offset + 3)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(JoinMessageWithUser entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(JoinMessageWithUser entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(JoinMessageWithUser entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}