# Spring-Security-Intro

1. Configure Spring Security Authentication

    1. get hold of AuthenticationManagerBuilder
    2. set the Configuration on it


2. Configure Spring Security Authorization

    1. get hold of HttpSecurity
    2. set the Configuration on it

<br>

# How Spring Security Authentication works [@](https://www.marcobehler.com/guides/spring-security)

[<img src="Screenshots/How Spring Security Authentication works.jpeg" alt="How Spring Security Authentication works" width="960"/>](https://www.marcobehler.com/guides/spring-security)


1. Spring Security Filter

    <center><img src="Screenshots/servlet-filter.png" alt="Servlet Filter" width="480"/></center>

2. AuthenticationProvider

    AuthenticationProvider takes instance of authentication with credentials & returns instance of authentication with principal 

    <center><img src="Screenshots/AuthenticationProvider.png" alt="AuthenticationProvider" width="480" height="300"/></center>

3. AuthenticationManager

    AuthenticationManager holds list of AuthenticationProvider instances. What this actually does is iterate over all instances of AuthenticationProvider and tries to authenticate user with each one. The actual authentication is performed inside AuthenticationProvider.

    <center><img src="Screenshots/AuthenticationManager I.png" alt="AuthenticationManager" width="430" height="300"/> <img src="Screenshots/AuthenticationManager II.png" alt="AuthenticationManager" width="430" height="300"/>
    </center>


4. UserDetailService

    The UserDetailsService interface is used to retrieve user-related data. It has one method named loadUserByUsername() which can be overridden to customize the process of finding the user. It is used by the DaoAuthenticationProvider to load details about the user during authentication

    <center><img src="Screenshots/UserDetailService I.png" alt="UserDetailService" width="450"/></center>
    <center><img src="Screenshots/UserDetailService II.png" alt="UserDetailService" width="450" /></center>

<i>
<b>AuthenticationManager</b> holds list of different <b>AuthenticationProvider</b> instances. It iterates over each instances of AuthenticationProvider and tries to authenticate user with each one. The actual authentication is performed inside <b>AuthenticationProvider</b>. Each AuthenticationProvider contains instance of <b>UserDetailsService</b> which is responsible for fetching user information (including hashed password) out of database for example, or LDAP. Once instance of UserDetails is successfully retrieved from database <b>AuthenticationProvider</b> will then use instance of <b>PasswordEncoder</b> to check whether password user provided matches hashed password you retrieved from database.
</i>