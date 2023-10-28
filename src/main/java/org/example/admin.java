package org.example;





    public class admin extends user {

        protected String adname;
        protected String adpassword;
        protected boolean adislogged;

        public admin(String name,String password)
        {
            this.adname = name;
            this.adpassword = password;
            this.adislogged = false;
        }

        public boolean login(String username,String password)
        {
            this.adislogged= this.adname.equals(username);
            this.adislogged = this.adpassword.equals(password);
            return this.adislogged;
        }


        public boolean logout()
        {
            this.adislogged = false;
            return this.adislogged;
        }

        public boolean isLogged()
        {
            return this.adislogged;
        }
    }


