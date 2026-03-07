package com.pm.patient_service.kafka;


import com.pm.patient_service.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KafkaProducer {
    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, byte[]> kafkaTemplate;

    // Optional setter injection - if no KafkaTemplate bean exists tests will still start
    @Autowired(required = false)
    public void setKafkaTemplate(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Patient patient){
        if (kafkaTemplate == null) {
            log.warn("KafkaTemplate not configured - skipping sending PatientCreated event for patient {}", patient.getId());
            return;
        }

        PatientEvent event = PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .setEventType("PATIENT_CREATED")
                .build();
        try{
            kafkaTemplate.send("patient", event.toByteArray());
        }
        catch (Exception e){
            log.error("Error sending PatientCreated event: {}",event);
        }
    }


}
