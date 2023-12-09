package dri.demo.model;

public enum CouponStatus {

  SERVICE_FULFILLMENT_STATUS_TYPE_UNKNOWN,
  SERVICE_FULFILLMENT_STATUS_TYPE_NOT_STARTED,
  SERVICE_FULFILLMENT_STATUS_TYPE_SECURE_SUBMITTED,
  SERVICE_FULFILLMENT_STATUS_TYPE_SECURE_ACCEPTED,
  SERVICE_FULFILLMENT_STATUS_TYPE_SECURE_REJECTED,
  SERVICE_FULFILLMENT_STATUS_TYPE_READY_TO_DELIVER,
  SERVICE_FULFILLMENT_STATUS_TYPE_DELIVERED,
  SERVICE_FULFILLMENT_STATUS_TYPE_CANCEL_SUBMITTED,
  SERVICE_FULFILLMENT_STATUS_TYPE_CANCEL_ACCEPTED,
  SERVICE_FULFILLMENT_STATUS_TYPE_CANCEL_REJECTED,
  SERVICE_FULFILLMENT_STATUS_TYPE_SECURE_WAITLISTED,
  UNRECOGNIZED;
}