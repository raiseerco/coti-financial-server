package io.coti.financialserver.controllers;

import io.coti.basenode.http.interfaces.IResponse;
import io.coti.financialserver.http.GetDocumentFileRequest;
import io.coti.financialserver.http.GetDocumentNamesRequest;
import io.coti.financialserver.http.NewDocumentRequest;
import io.coti.financialserver.services.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public ResponseEntity<IResponse> newDocument(@ModelAttribute @Valid NewDocumentRequest request) {
        return documentService.newDocument(request);
    }

    @RequestMapping(path = "/names", method = RequestMethod.POST)
    public ResponseEntity<IResponse> getDocumentNames(@RequestBody @Valid GetDocumentNamesRequest request) {

        return documentService.getDocumentNames(request);
    }

    @RequestMapping(path = "/{userHash}/{r}/{s}/{documentHash}", method = RequestMethod.GET)
    public void getDocumentFile(@ModelAttribute @Valid GetDocumentFileRequest request, HttpServletResponse response) throws IOException {

        documentService.getDocumentFile(request, response);
        response.flushBuffer();
    }
}
