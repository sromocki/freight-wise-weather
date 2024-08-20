import { toZonedTime, format as formatTZ } from 'date-fns-tz';

export function moonPhaseToString(phase: number): string {
  if (phase === 0 || phase === 1) return 'New Moon';
  if (phase === 0.25) return 'First Quarter Moon';
  if (phase === 0.5) return 'Full Moon';
  if (phase === 0.75) return 'Last Quarter Moon';
  if (phase > 0 && phase < 0.25) return 'Waxing Crescent';
  if (phase > 0.25 && phase < 0.5) return 'Waxing Gibbous';
  if (phase > 0.5 && phase < 0.75) return 'Waning Gibbous';
  if (phase > 0.75 && phase < 1) return 'Waning Crescent';
  return 'Unknown Phase';
}

export function capitalizeWords(description: string): string {
  return description.replace(/\b\w/g, char => char.toUpperCase());
}

export function formattedDate(timestamp: number, timezone: string): string {
  const date = toZonedTime(timestamp * 1000, timezone);
  return formatTZ(date, 'MMMM d, yyyy hh:mm:ss a z', { timeZone: timezone });
}

/**
 * Converts a Unix timestamp to a formatted date string.
 * @param timestamp - The Unix timestamp to format.
 * @param timezone - The timezone string.
 * @returns A formatted date string.
 */
export function formattedDateOnly(timestamp: number, timezone: string): string {
  const date = toZonedTime(timestamp * 1000, timezone);
  return formatTZ(date, 'MMMM d, yyyy', { timeZone: timezone });
}

/**
 * Formats a timestamp to an hour string without leading zero.
 * @param timestamp - The timestamp in seconds.
 * @param timezone - The timezone string.
 * @returns The formatted hour string.
 */
export function formatHour(timestamp: number, timezone: string): string {
  const date = toZonedTime(timestamp * 1000, timezone);
  return formatTZ(date, 'h a', { timeZone: timezone });
}

/**
 * Formats a timestamp to a time string with timezone.
 * @param timestamp - The timestamp in seconds.
 * @param timezone - The timezone string.
 * @returns The formatted time string.
 */
export function formatTime(timestamp: number, timezone: string): string {
  const date = toZonedTime(timestamp * 1000, timezone);
  return formatTZ(date, 'hh:mm:ss a z', { timeZone: timezone });
}

/**
 * Converts a Unix timestamp to a readable day format.
 * @param timestamp - The Unix timestamp to format.
 * @param timezone - The timezone offset in seconds.
 * @returns A formatted day string.
 */
export function formatDay(timestamp: number, timezone: string): string {
  const date = toZonedTime(timestamp * 1000, timezone);
  return formatTZ(date, 'EEEE, MMM d', { timeZone: timezone });
}

/**
 * Converts wind direction in degrees to a compass direction.
 * @param degrees - The wind direction in degrees.
 * @returns The compass direction.
 */
export function windDirection(degrees: number): string {
  const directions = ['N', 'NNE', 'NE', 'ENE', 'E', 'ESE', 'SE', 'SSE', 'S', 'SSW', 'SW', 'WSW', 'W', 'WNW', 'NW', 'NNW'];
  const index = Math.round(degrees / 22.5) % 16;
  return directions[index];
}

/**
 * Converts millimeters to inches.
 * @param mm - The value in millimeters.
 * @returns The value in inches, rounded to two decimal places.
 */
export function convertMmToInches(mm: number): number {
  return parseFloat((mm / 25.4).toFixed(2));
}

/**
 * Converts visibility in meters to kilometers.
 * @param meters - The visibility in meters.
 * @returns The visibility in kilometers, rounded to two decimal places.
 */
export function visibilityInKm(meters: number): number {
  return parseFloat((meters / 1000).toFixed(2));
}
