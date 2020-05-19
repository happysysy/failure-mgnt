package com.lottevn.core.util;

import static org.springframework.util.StringUtils.isEmpty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import lombok.NonNull;


public class DateUtil {
    /**
     * 시간 객체를 특정 형식의 String으로 변형
     *
     * @param temporal 문자열로 변환할 일시 ({@link java.time.ZonedDateTime}, {@link java.time.OffsetDateTime},
     *            {@link java.time.OffsetTime}, {@link java.time.LocalDateTime},
     *            {@link java.time.LocalDate}, {@link java.time.LocalTime})
     * @param timeFormat 원하는 return 형식 (예: "yyyy-MM-dd")
     *
     * @return 변환된 문자열. 변환 불가 시 null.
     * @author brad
     */
    public static <T extends Temporal> String temporalToStr(final T temporal, @NonNull final String timeFormat) {
        if (temporal == null || isEmpty(timeFormat)) {
            return null;
        }

        try {
            if (temporal instanceof ZonedDateTime) {
                return ((ZonedDateTime) temporal).format(DateTimeFormatter.ofPattern(timeFormat));
            } else if (temporal instanceof OffsetDateTime) {
                return ((OffsetDateTime) temporal).format(DateTimeFormatter.ofPattern(timeFormat));
            } else if (temporal instanceof OffsetTime) {
                return ((OffsetTime) temporal).format(DateTimeFormatter.ofPattern(timeFormat));
            } else if (temporal instanceof LocalDateTime) {
                return ((LocalDateTime) temporal).format(DateTimeFormatter.ofPattern(timeFormat));
            } else if (temporal instanceof LocalDate) {
                return ((LocalDate) temporal).format(DateTimeFormatter.ofPattern(timeFormat));
            } else if (temporal instanceof LocalTime) {
                return ((LocalTime) temporal).format(DateTimeFormatter.ofPattern(timeFormat));
            }

            return null;

        } catch (final Exception e) {
            return null;
        }
    }

    /**
     * 일시 문자열의 형식 검사 및 시간 객체로 변환.
     *
     * @param strTemporal 일시 문자열
     * @param timeFormats value의 형식목록. 가장 먼저 일치하는 형식이 사용됨. (예: Arrays.asList("yyyyMMdd HHmmss", "yyyy-MM-dd HH:mm:ss"))
     * @param returnType 원하는 return 객체 형식 ({@link java.time.ZonedDateTime}, {@link java.time.OffsetDateTime},
     *            {@link java.time.OffsetTime}, {@link java.time.LocalDateTime},
     *            {@link java.time.LocalDate}, {@link java.time.LocalTime} 중 택 1)
     * @param zoneId ZonedDatetime처럼 지역코드가 필요한 객체로 변환하는 경우 입력
     *
     * @return parse 된 객체. parse 불가하면 null.
     * @see "https://stackoverflow.com/a/20232680/2652379"
     * @author brad
     */
    @SuppressWarnings("unchecked")
    public static <T extends Temporal> T strToTemporal(final String strTemporal, @NonNull final List<String> timeFormats,
                                                       @NonNull final Class<T> returnType, final ZoneId zoneId) {
        if (isEmpty(strTemporal)) {
            return null;
        }

        for (final String format : timeFormats) {
            try {
                if (returnType == ZonedDateTime.class) {
                    return (T) ZonedDateTime.parse(strTemporal, DateTimeFormatter.ofPattern(format).withZone(zoneId));
                } else if (returnType == OffsetDateTime.class) {
                    return (T) OffsetDateTime.parse(strTemporal, DateTimeFormatter.ofPattern(format));
                } else if (returnType == OffsetTime.class) {
                    return (T) OffsetTime.parse(strTemporal, DateTimeFormatter.ofPattern(format));
                } else if (returnType == LocalDateTime.class) {
                    return (T) LocalDateTime.parse(strTemporal, DateTimeFormatter.ofPattern(format));
                } else if (returnType == LocalDate.class) {
                    return (T) LocalDate.parse(strTemporal, DateTimeFormatter.ofPattern(format));
                } else if (returnType == LocalTime.class) {
                    return (T) LocalTime.parse(strTemporal, DateTimeFormatter.ofPattern(format));
                } else {
                    throw new IllegalArgumentException("사용 불가능한 클래스 형식입니다.");
                }

            } catch (final DateTimeParseException e) {
                //실패 시 무시하고 다음 형식으로 시도
            }
        }

        return null;
    }

    /**
     * 일시 문자열을 다른 형식의 일시 문자열로 변경
     *
     * @param strTemporal 일시 문자열
     * @param inputTimeFormats value의 형식목록. 가장 먼저 일치하는 형식이 사용됨. (예: Arrays.asList("yyyyMMdd HHmmss", "yyyy-MM-dd
     *            HH:mm:ss"))
     * @param outputTimeFormat return 형식 (예: "yyyy-MM-dd")
     * @param parseType parse를 수행할 객체 형식 ({@link java.time.ZonedDateTime}, {@link java.time.OffsetDateTime},
     *            {@link java.time.OffsetTime}, {@link java.time.LocalDateTime},
     *            {@link java.time.LocalDate}, {@link java.time.LocalTime} 중 택 1)
     * @param zoneId ZonedDatetime처럼 지역코드가 필요한 객체로 변환하는 경우 입력
     *
     * @return 변환된 문자열. 불가 시 null.
     */
    public static <T extends Temporal> String strToStr(final String strTemporal, @NonNull final List<String> inputTimeFormats,
                                                       @NonNull final String outputTimeFormat, @NonNull final Class<T> parseType, final ZoneId zoneId) {
        final T dateTime = strToTemporal(strTemporal, inputTimeFormats, parseType, zoneId);
        if (dateTime == null) {
            return null;
        }

        return temporalToStr(dateTime, outputTimeFormat);
    }

    public static String getDateTimeByPattern(String pattern)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);

        String dateString = formatter.format(new Date());

        return dateString;
    }

    public static String getToday()
    {
        String msgDate = getDateTimeByPattern("yyyyMMdd");
        return msgDate;
    }

    /**
     * 시간을 시/분(4자리)만취득하여 구분형식으로 취득한다
     * @param dateTime 4자리시간데이터
     * @param pattern (：)구분형식
     * @return String 취득한시간데이터
     */
    public static String getTimeFormat(String dateTime, String pattern){
        StringBuffer sbDate = new StringBuffer("");
        if ( dateTime != null && dateTime.length() >= 4){
            sbDate.append(dateTime.substring(0, 2));
            sbDate.append(pattern);
            sbDate.append(dateTime.substring(2, 4));
        }
        if ( dateTime != null && dateTime.length() == 6){
            sbDate.append(pattern);
            sbDate.append(dateTime.substring(4, 6));
        }
        return sbDate.toString();
    }

    /**
     * 날짜＋시간데이터１２자리를날짜시간별로 정형화해서 보여준다
     * @param dateTime 12행날짜+시간데이터
     * @param pattern (-,/)날짜구분형식
     * @return String 취득결과데이터
     */
    public static String getDateTime(String dateTime, String pattern){
        StringBuffer sbDate = new StringBuffer("");
        if ( dateTime != null && dateTime.length() >= 12){
            sbDate.append(dateTime.substring(0, 4));
            sbDate.append(pattern);
            sbDate.append(dateTime.substring(4, 6));
            sbDate.append(pattern);
            sbDate.append(dateTime.substring(6, 8));
            sbDate.append(" ");
            sbDate.append(dateTime.substring(8, 10));
            sbDate.append(":");
            sbDate.append(dateTime.substring(10, 12));
        }
        if ( dateTime != null && dateTime.length() == 14){
            sbDate.append(":");
            sbDate.append(dateTime.substring(12, 14));
        }
        return sbDate.toString();
    }
}
