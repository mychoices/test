package com.blueprint.basic;

/**
 * @another 江祖赟
 * @date 2017/12/24 0024.
// ResultType: Type for the Resource data
// RequestType: Type for the API response
 */
// ResultType: Type for the Resource data
// RequestType: Type for the API response
public abstract class NetworkBoundResource<ResultType, RequestType> {
    // Called to save the result of the API response into the database
//    @WorkerThread
//    protected abstract void saveCallResult(@NonNull RequestType item);
//
//    // Called with the data in the database to decide whether it should be
//    // fetched from the network.
//    @MainThread
//    protected abstract boolean shouldFetch(@Nullable ResultType data);
//
//    // Called to get the cached data from the database
//    @NonNull @MainThread
//    protected abstract LiveData<ResultType> loadFromDb();
//
//    // Called to create the API call.
//    @NonNull @MainThread
//    protected abstract LiveData<ApiResponse<RequestType>> createCall();
//
//    // Called when the fetch fails. The child class may want to reset components
//    // like rate limiter.
//    @MainThread
//    protected void onFetchFailed() {
//    }
//
//    // returns a LiveData that represents the resource, implemented
//    // in the base class.
//    public final LiveData<Resource<ResultType>> getAsLiveData();
}