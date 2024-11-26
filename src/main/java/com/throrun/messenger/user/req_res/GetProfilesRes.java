package com.throrun.messenger.user.req_res;

import com.throrun.messenger.user.data.model.Profile;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetProfilesRes {
    private List<Profile> profiles;
}
