package com.jonasrosendo.aws_api.web.mapper

import com.jonasrosendo.aws_api.domain.dtos.request_stages.CreateRequestStageDTO
import com.jonasrosendo.aws_api.domain.enums.RequestState
import com.jonasrosendo.aws_api.domain.models.Request
import com.jonasrosendo.aws_api.domain.models.RequestStage
import java.util.Date

fun CreateRequestStageDTO.toRequestStage(
    request: Request,
): RequestStage {

    return RequestStage(
        description = description,
        realizationDate = Date(),
        state = RequestState.OPEN,
        request = request,
        owner = request.owner
    )
}