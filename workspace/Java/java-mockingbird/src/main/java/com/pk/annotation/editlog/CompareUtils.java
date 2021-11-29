package com.pk.annotation.editlog;

import com.pk.annotation.editlog.EditLog;

import java.lang.reflect.Field;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipFile;

/**
 * bean diff util
 *
 * @author Kipeng Huang <huangpeng08@baidu.com>
 * @since 2021/5/27 2:40 下午
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class CompareUtils {
    /**
     * bean diff
     *
     * @param oldVersion
     * @param newVersion
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static <T> List<EditLog> compare(T oldVersion, T newVersion) throws IllegalAccessException {
        List<EditLog> editLogList = new ArrayList<>();
        // 两个值至少一个不为null
        Field[] fields;
        if (null != oldVersion) {
            fields = oldVersion.getClass().getDeclaredFields();
            // null != newVersion && null != oldVersion
            if (null != newVersion) {
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(FieldComparable.class)) {
                        if (null != field.get(oldVersion) && null != field.get(newVersion)
                                && !oldVersion.equals(newVersion)) {
                            editLogList.add(EditLog.builder().field(field.getName())
                                    .name(field.getAnnotation(FieldComparable.class).zhName())
                                    .oldValue(field.get(oldVersion).toString()).newValue(null)
                                    .operatedTime(Instant.now().getEpochSecond())
                                    .build());
                        }
                    }
                }
            } else {
                // null == newVersion && null != oldVersion
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(FieldComparable.class)) {
                        if (null != field.get(oldVersion)) {
                            editLogList.add(EditLog.builder().field(field.getName())
                                    .name(field.getAnnotation(FieldComparable.class).zhName())
                                    .oldValue(field.get(oldVersion).toString()).newValue(null)
                                    .operatedTime(Instant.now().getEpochSecond())
                                    .build());
                        }
                    }
                }
            }
        } else if (null != newVersion) {
            // null != newVersion && null == oldVersion
            fields = newVersion.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(FieldComparable.class)) {
                    if (null != field.get(newVersion)) {
                        editLogList.add(EditLog.builder().field(field.getName())
                                .name(field.getAnnotation(FieldComparable.class).zhName())
                                .oldValue(null).newValue(field.get(newVersion).toString())
                                .operatedTime(Instant.now().getEpochSecond())
                                .build());
                    }
                }
            }
        }
        return editLogList;
    }

    public static void main(String[] args) {
        AccountInfo oleTom = AccountInfo.builder()
                .accountName("TOM")
                .company("INC")
                .salary(2001)
                .build();
        AccountInfo newTom = AccountInfo.builder()
                .accountName("TOM")
                .company("INCC")
                .salary(2021)
                .build();
        try {
            System.out.println(CompareUtils.compare(oleTom, newTom));
            System.out.println(CompareUtils.compare(null, newTom));
            System.out.println(CompareUtils.compare(oleTom, null));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
