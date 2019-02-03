package util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class CommonConverterTools {
    /**
     * 对象转换
     *
     * @param clazz  转换后的类
     * @param object 被转后的对象
     * @return
     */
    public static <T> T convert(Class<T> clazz, Object object) {
        return ofNullable(object).map(o -> {
            T obj = null;
            try {
                obj = clazz.newInstance();
                BeanUtils.copyProperties(obj, o);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return obj;
        }).orElse(null);
    }

    public static <T, D> List<T> convert(Class<T> clazz, List<D> objList) {
        return objList.stream().map(obj -> convert(clazz, obj))
                .collect(Collectors.toList());
    }
}