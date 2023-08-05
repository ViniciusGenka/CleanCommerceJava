package com.genka.cleancommerce.application.user.usecases;

import com.genka.cleancommerce.application.user.usecases.dtos.GetUserProfileInput;
import com.genka.cleancommerce.domain.user.dtos.UserDTO;

import java.util.UUID;

public interface GetUserProfile {
    UserDTO execute(GetUserProfileInput getUserProfileInput);
}
