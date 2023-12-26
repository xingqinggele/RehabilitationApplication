package com.example.rehabilitationapplication.persenter;

import android.content.Context;

import com.example.rehabilitationapplication.bean.LoginBean;
import com.example.rehabilitationapplication.model.ILoginModel;
import com.example.rehabilitationapplication.model.LoginModel;
import com.example.rehabilitationapplication.util.SPUtils;
import com.example.rehabilitationapplication.view.LoginView;


/**
 * 作者: qgl
 * 创建日期：2022/11/30
 * 描述:登录P层
 */
public class LoginPresenter<T extends LoginView> extends BasePresenter {

    ILoginModel model = new LoginModel();

    public void login(Context context, boolean checked, String userName, String passWord) {
        ((T) iGoodsView.get()).showProgress();
        if (iGoodsView.get() != null && model != null) {

            model.login(userName, passWord, new ILoginModel.OnLoadListener() {
                @Override
                public void showData(LoginBean bean) {
                    ((T) iGoodsView.get()).downProgress();
                    //本地存储用户名
//                    SPUtils.put(context, "userName", bean.getLoginUser().getUser().getUserName());
//                    //如果用户点击记住密码、存储密码到本地
//                    if (checked) {
//                        //本地存储密码
//                        SPUtils.put(context, "passWord", passWord);
//                    }
//                    SPUtils.put(context, "ticket", bean.getTicket());
//                    SPUtils.put(context, "userId", bean.getLoginUser().getUser().getUserId());
//                    SPUtils.put(context, "secretId", bean.getSecretId());
//                    SPUtils.put(context, "secretKey", bean.getSecretKey());
//                    SPUtils.put(context, "bucketName", bean.getBucketName());
//                    SPUtils.put(context, "createTime", bean.getLoginUser().getUser().getCreateTime());
//                    SPUtils.put(context, "Token", bean.getToken());
                    ((T) iGoodsView.get()).showGoodList(bean);
                }

                @Override
                public void showError(String msg) {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).showErrorMessage(msg);
                }
            });
        }

    }

} 