package pe.com.orbis.storesdk.service.login;

import pe.com.orbis.storesdk.api.ErrorUtil;
import pe.com.orbis.storesdk.api.StoreApiManager;
import pe.com.orbis.storesdk.model.request.LoginRequest;
import pe.com.orbis.storesdk.model.response.ErrorResponse;
import pe.com.orbis.storesdk.model.response.LoginResponse;
import pe.com.orbis.storesdk.util.Urls;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ricardo Bravo on 30/01/17.
 */

public class LoginService {

    public static void login(LoginRequest loginRequest, final LoginCallback callback){

        Call<LoginResponse> call = StoreApiManager.apiManager().login(Urls.URL_REGISTER, loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    callback.onLoginResponse(response.body());
                }else{
                    callback.onLoginError(ErrorUtil.parseError(response));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                ErrorResponse errorResponse = new ErrorResponse();
                ErrorResponse.MetaBean metaBean = new ErrorResponse.MetaBean();
                metaBean.setCode("1000");
                metaBean.setMessage(t.getMessage());
                metaBean.setStatus("500");
                errorResponse.set_meta(metaBean);
                callback.onLoginError(errorResponse);
            }
        });

    }

}
