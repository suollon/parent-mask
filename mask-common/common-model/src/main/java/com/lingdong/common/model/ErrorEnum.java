package com.lingdong.common.model;

/**
 * Devops规范详见：http://devops.gyjxwh.com/#/knowledge/share/f0de194413056248
 * 成功标识   100000
 * 错误标识   110xxx   前三位为系统码，代表营销平台；后三位为具体的业务错误码
 */
public enum ErrorEnum {

    /*********************** 通用 ***********************/
    SUCCESS(100000, "操作成功！"),
    BAD_PARAMETER(110400, "{}"),
    UNAUTHORIZED(110401, "参数解析器获取用户信息失败"),
    NOT_SET_AUTH_CODE(110402, "未设置 authCode!"),
    NOT_SET_OUT_PLATFORM(110403, "未设置 outPlatform!"),
    INTERNAL_ERROR(110500, "系统异常！"),

    /*********************** 活动异常 ***********************/
    //活动不存在
    ACTIVITY_NOT_EXIST(110100, "当前服务繁忙，请稍后再试"),
    //活动未开始，请等待
    ACTIVITY_NOT_START(110101, "活动还未开始，请耐心等一等哦"),
    //活动已结束
    ACTIVITY_ENDED(110102, "本次活动已结束，下次记得早点来哦"),
    //活动已下架
    ACTIVITY_OFFLINE(110103, "活动正在调整中，请耐心等待哦"),
    //活动已终止
    ACTIVITY_TERMINATION(110104, "本次活动已结束~"),
    ACTIVITY_UI_NOT_EXIST(110121, "活动UI信息不存在"),
    ACTIVITY_UI_DOWNLOAD_FAIL(110122, "从OSS服务器下载活动UI信息异常"),

    /*********************** 奖品异常 ***********************/
    //抽奖失败，奖品库存不足
    PRIZE_INVENTORY_NOT_ENOUGH(110200, "很遗憾，您与大奖擦肩而过~"),

    /*********************** 规则异常 ***********************/
    //限制用户活动总抽奖次数，达到上限
    TOTAL_LIMIT(110300, "您当前已经没有抽奖机会啦~"),
    //限制每天用户参与活动次数限制，达到上限
    PERDAY_LIMIT(110301, "您今天已经没有抽奖机会啦，记得明天再来哦~"),

    /*********************** 获取支付用户信息异常 ***********************/
    PRIVATE_KEY_NOT_EXIST(110600, "找不到相应的查询秘钥"),

    /*********************** 其他异常 ***********************/
    //抽奖失败，发送MQ消息异常
    RMQ_SEND_EXCEPTION(110700, "很遗憾，您与大奖擦肩而过~"),
    REPEAT_DRAW_EXCEPTION(110701, "您的速度太快啦~"),

    //领取奖品时候，重复领取界面提示
    REPEAT_RECEIVE_EXCEPTION(110702, "您已领取过该奖品，请勿重复提交~"),
    //领取奖品时候，抽奖id不存在
    DRAW_ID_NONE(110703, "请稍后再试~"),
    ;

    private int code;
    private String message;

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
