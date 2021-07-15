# Spring-Security

Spring Security is a Java/Java EE framework that provides authentication, authorization and other security features for enterprise applications. 

* Handles common vulnerabilities

    * session fixation
    * Clickjacking
    * Click site request forgery


* what Spring Security can do :

    * User name/password authentication
    * SSO/Okta/LDAP
    * App level Authorization
    * Intra App Authorization like OAuth
    * Microservice security (using tokens, JWT)


# Basics

1. <b>Authentication</b> (Who are you)

    One of the fundamental ways to secure a resource is to make sure that the caller is who they claim to be. This process of checking credentials and making sure that they are genuine is called authentication.

    * knowledge based authentication : Password OR Pin code OR Answer to secret/personal question 
    * Possession based authentication : Phone or Text messages OR Key-cards/Badges OR Access token device
    * Multi-Factor authentication

2. <b>Authorization</b> (Can this user do this)

    Store : Customer vs Store Clerk vs Department Manager vs Manager

3. <b>Principal</b> (Currently logged in user)

    A Principal represents a user's identity. It can be a String object having username on a simple level or a complex UserDetails object.

4. <b>GrantedAuthority</b> (permission or a right)

    granting different GrantedAuthorities (permissions) to users 

5. <b>Roles</b> (bunch of permissions)

    Admin vs User

