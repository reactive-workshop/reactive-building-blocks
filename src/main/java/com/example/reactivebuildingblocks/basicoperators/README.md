# Publishers
There are two type of publishers in project-reactor.
- [Mono](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html): Used for publishing maximum one element
- [Flux](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html): Used for publishing more than one elements

Examples:
- Two collections:
    - [Independent Model] User => id, name, gender, age, mobile
    - [Independent Model] KYC => user_id, document_type, document_number, expired
    - [Composite Model] KYCProfile => user_id, name, gender, age, document_type, document_number


- Fetch A single user by id
- Search users by name
- Get All users
- Get All users anonymised Without name
- Get KYCProfile for a user by mobile
- Get KYCProfile of a user by id 
- Get Users with age between 18 to 20
- Throw UserNotFoundError when we cannot find user by given ID
- Throw KYCNotFoundError when we cannot find KYC for a UserId
- Change UserNotFoundError and KycNotFoundError to ResourceNotFoundError, any other error should give ApplicationError
- Proive default KYC as document_type `NONE` & document_number `00000` when KYC Not Found for user 
- GetKycFrom Cache/Hashmap for given Id if present and fetch from DB if it is not found in cache
- Make the fetch is not called when entry is found in the cache 