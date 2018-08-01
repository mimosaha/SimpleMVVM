# SimpleMVVM
A MVVM pattern has been achieved on a simple data load project
### View
Class name
```
MainActivity
```
### ViewModel
Class name
```
UserViewModel
```
### Model (DataModel)
Class name
```
ServerHitHelper and ServerResponse
```

### Mechanism
MainActivity -> UserViewModel (Via fetchUserList API)

UserViewModel -> ServerHitHelper and ServerHitService (Using Observable)

ServerHitService -> UserViewModel (Send user using ServerResponse)

UserViewModel -> MainActivity (Via Observer)
