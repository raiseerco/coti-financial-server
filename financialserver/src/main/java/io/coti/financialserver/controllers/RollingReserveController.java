package io.coti.financialserver.controllers;

import io.coti.basenode.http.GetMerchantRollingReserveAddressRequest;
import io.coti.basenode.http.interfaces.IResponse;
import io.coti.financialserver.http.GetMerchantRollingReserveDataRequest;
import io.coti.financialserver.http.RecourseClaimRequest;
import io.coti.financialserver.services.RollingReserveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/rollingReserve")
public class RollingReserveController {

    @Autowired
    RollingReserveService rollingReserveService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity getRollingReserveData(@Valid @RequestBody GetMerchantRollingReserveDataRequest request) {

        return rollingReserveService.getRollingReserveData(request);
    }

    @RequestMapping(path = "/recourseClaim", method = RequestMethod.POST)
    public ResponseEntity recourseClaim(@Valid @RequestBody RecourseClaimRequest request) {

        return rollingReserveService.recourseClaim(request);
    }

    @RequestMapping(path = "/merchantReserveAddress", method = RequestMethod.POST)
    public ResponseEntity<IResponse> getMerchantRollingReserveAddress(@Valid @RequestBody GetMerchantRollingReserveAddressRequest request) {

        return rollingReserveService.getMerchantRollingReserveAddress(request);
    }
}
