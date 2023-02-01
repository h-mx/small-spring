package com.mx.springframework.beans.factory;

/**
 * 标记超接口，指示bean有资格通过回调样式的方法由Spring容器通知特定框架对象。实际的方法签名由各个子接口决定，但通常应该只包含一个接受单个参数的返回void的方法。
 * <p>
 * 标记类接口，实现该接口可以被Spring容器感知
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/10
 */
public interface Aware {
}
