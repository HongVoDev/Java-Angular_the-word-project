package com.journal.backendJournal;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
public class JournalController {
  private JournalService journalService = new JournalService();
  private EmotionAnalysisService emotionAnalysisService = new EmotionAnalysisService();
  private static final ZoneId GMT_MINUS_5 = ZoneId.of("America/Chicago");

  @Autowired
  public JournalController(JournalService journalService, EmotionAnalysisService emotionAnalysisService) {
    this.journalService = journalService;
    this.emotionAnalysisService = emotionAnalysisService;
  }

  @PostMapping("/getVersesByEntry")
  public List analyzeEmotion(@RequestBody String text, HttpServletRequest request) {
    try {
      return journalService.getThreeVersesByKeyword(emotion);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @GetMapping("/healthcheck")
  public ResponseEntity healthCheck() {
    return ResponseEntity.ok("OK");
  }
}