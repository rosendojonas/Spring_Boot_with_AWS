package com.jonasrosendo.aws_api.utils


object RestConstants {
    private const val API_V1 = "api/v1"

    object Users {
        private const val USERS = "users"

        /**
         * api/v1/users
         **/
        const val ROOT_USER_CONTROLLER = "$API_V1/$USERS"


    }

    object Requests {
        private const val REQUESTS = "requests"

        /**
         * api/v1/requests
         **/
        const val ROOT_REQUEST_CONTROLLER = "$API_V1/$REQUESTS"
    }

    object Auth {
        private const val AUTH = "auth"

        /**
         * api/v1/auth
         **/
        const val ROOT_AUTH_CONTROLLER = "$API_V1/${AUTH}"

    }


    object RequestStages {
        private const val REQUEST_STAGES = "request-stages"

        /**
         * api/v1/request-stages
         **/
        const val ROOT_REQUEST_STAGE_CONTROLLER = "$API_V1/$REQUEST_STAGES"

    }

}

