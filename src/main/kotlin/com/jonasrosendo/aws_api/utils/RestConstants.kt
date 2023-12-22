package com.jonasrosendo.aws_api.utils


object RestConstants {
    private const val API_V1 = "api/v1"

    object Users {
        private const val USERS = "users"
        private const val LOGIN = "login"

        /**
         * api/v1/users
         **/
        const val ROOT_USER_CONTROLLER = "$API_V1/$USERS"

        /**
         * api/v1/user/login
         **/
        const val LOGIN_PATH = "/login"
    }

    object Requests {
        private const val REQUESTS = "requests"

        /**
         * api/v1/requests
         **/
        const val ROOT_REQUEST_CONTROLLER = "$API_V1/$REQUESTS"
    }


    object RequestStages {
        private const val REQUEST_STAGES = "request-stages"

        /**
         * api/v1/request-stages
         **/
        const val ROOT_REQUEST_CONTROLLER = "$API_V1/$REQUEST_STAGES"

    }

}

