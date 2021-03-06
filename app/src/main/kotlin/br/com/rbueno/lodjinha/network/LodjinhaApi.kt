package br.com.rbueno.lodjinha.network

import br.com.rbueno.lodjinha.model.Banner
import br.com.rbueno.lodjinha.model.Category
import br.com.rbueno.lodjinha.model.Product
import br.com.rbueno.lodjinha.model.ProductList
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LodjinhaApi {

    @GET("banner")
    fun getBanner(): Single<Banner>

    @GET("categoria")
    fun getCategory(): Single<Category>

    @GET("produto/maisvendidos")
    fun getProductsMostSold(): Single<ProductList>

    @GET("produto/{produtoId}")
    fun getProduct(@Path("produtoId") productId: Int): Single<Product>

    @POST("produto/{produtoId}")
    fun reserveProduct(@Path("produtoId") productId: Int): Completable

    @GET("produto")
    fun loadProductListPage(
        @Query("categoriaId") categoryId: Int,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Single<ProductList>
}