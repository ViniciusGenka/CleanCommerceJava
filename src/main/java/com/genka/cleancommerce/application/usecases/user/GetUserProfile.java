package com.genka.cleancommerce.application.usecases.user;

import com.genka.cleancommerce.application.usecases.user.dtos.GetUserProfileInput;
import com.genka.cleancommerce.domain.user.dtos.UserDTO;

public interface GetUserProfile {
    UserDTO execute(GetUserProfileInput getUserProfileInput);
}
