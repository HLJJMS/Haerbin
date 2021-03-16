package com.example.haerbin.network

object Api {

    //13:5F:00:95:E0:EF:FB:50:16:67:6D:27:12:85:9B:CF:48:C1:4C:AB

    const val BASE_URL = "http://wuyouban.yundianx.com/wxapi/"

    //便民服务列表
    const val HANDYLIST = "handy/index"

    //公告列表
    const val NOTICE_LIST = "notice/index"

    //手机号登录
    const val PHONE_LOGIN = "user/login"


    //    部门列表
    const val DEPARTMENT_LIST = "department/index"

    //部门详情
    const val DEPARTMENT_DETAIL = "department/detail"

    // 个人注册1
    const val REGISTER_PERSON_1 = "user/reg_person_1"

    // 个人注册2
    const val REGISTER_PERSON_2 = "user/reg_person_2"


    const val REGISTER_COMPANY_1 = "user/reg_company_1"

    const val REGISTER_COMPANY_2 = "user/reg_company_2"

    const val REGISTER_COMPANY_3 = "user/reg_company_3"

    //验证码注册
    const val REGISTER_SEND_CODE = "user/reg_send_sms"

    //验证码改手机号
    const val EDITPHONE_SEND_CODE = "user/find_send_sms"

    //发送验证码（普发）
    const val SEND_MESSAGE = "user/send_sms"

    //新闻列表
    const val NEWS_LIST = "article/index"

    //修改手机号
    const val EDITPHONE = "user/update_mobile"

    //修改密码
    const val EDIT_PASSWORD = "user/update_password"

    //发送投诉
    const val POST_COMPLAINT = "complaint/submit"

    //投诉列表
    const val GET_MY_COMPLAINT = "complaint/index"

    //投诉列表
    const val DEL_MY_COMPLAINT = "complaint/delete"

    //纠错
    const val POST_ERROR = "fault/submit"

    //纠错列表获取
    const val GET_ERROR = "fault/index"

    //纠错删除
    const val DEL_ERROR = "fault/delete"

    //反馈
    const val FEEDBACK = "feedback/submit"

    //上传文件
    const val UPLOAD_FILE = "common/uploadfile"

    //发起咨询
    const val CREATE_ASK = "consult/submit"

}