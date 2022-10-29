# Publishers
There are two type of publishers in project-reactor.
- [Mono](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html): Used for publishing maximum one element
- [Flux](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html): Used for publishing more than one elements

Examples:
- Two collections:
    - [Independent Model] User => id, name, gender, age, mobile
    - [Independent Model] KYC => user_id, document_type, document_number
    - [Composite Model] KYCProfile => user_id, name, gender, age, document_type, document_number
  
- Fetch A single user by id #Already implemented
- Fetch A single KYC by id #Already implemented
- Get All users #Already implemented

- Search users by name #Controller should be there, returning a Flux.empty(). Fix this.
- Get All users anonymised Without name and mobile #Controller should be there. map - make name ### and mobile ***
- Get Users with age more than 18 #filter

- Get KYCProfile for a user by mobile #Need repository method and controller method.
- Get KYCProfile of a user by id #Mono.zip 

- Throw UserNotFoundError when we cannot find user by given ID #switchIfEmpty
- Throw KYCNotFoundError when we cannot find KYC for a UserId #switchIfEmpty

- Change UserNotFoundError to ResourceNotFoundError, any other error should give ApplicationError #onErrorMap
- Provide default KYC as document_type `NONE` & document_number `00000` when KYC Not Found for user #onErrorResume