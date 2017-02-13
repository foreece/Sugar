package com.reece.network.http;

import com.reece.network.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by foreece@gmail.com on 17-2-13.
 */

public interface IGithubService {
    @GET
    Call<List<Repo>> getRepos(String username);

    @GET
    Call<List<Repo>> getPublic(String username);
}
