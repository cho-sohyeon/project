const BASE_URL = '/api/exercise-logs';

export async function registerExerciseLog({ exerciseName, weight, reps, sets }) {
  const response = await fetch(BASE_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ exerciseName, weight, reps, sets }),
  });

  const data = await response.json();

  if (!response.ok) {
    throw new Error(data.message || '운동 기록 등록에 실패했습니다.');
  }

  return data;
}
