import { useState } from 'react';
import { registerExerciseLog } from '../api/exerciseLogApi';

const initialForm = {
  exerciseName: '',
  weight: '',
  reps: '',
  sets: '',
};

function ExerciseLogRegisterPage() {
  const [form, setForm] = useState(initialForm);
  const [status, setStatus] = useState(null); // { type: 'success' | 'error', message }
  const [submitting, setSubmitting] = useState(false);

  function handleChange(event) {
    const { name, value } = event.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  }

  async function handleSubmit(event) {
    event.preventDefault();
    setSubmitting(true);
    setStatus(null);

    try {
      await registerExerciseLog({
        exerciseName: form.exerciseName,
        weight: Number(form.weight),
        reps: Number(form.reps),
        sets: Number(form.sets),
      });
      setStatus({ type: 'success', message: '운동 기록이 등록되었습니다.' });
      setForm(initialForm);
    } catch (error) {
      setStatus({ type: 'error', message: error.message });
    } finally {
      setSubmitting(false);
    }
  }

  return (
    <section>
      <h1>운동 기록 등록</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="exerciseName">운동명</label>
          <input
            id="exerciseName"
            name="exerciseName"
            type="text"
            value={form.exerciseName}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="weight">중량 (kg)</label>
          <input
            id="weight"
            name="weight"
            type="number"
            step="0.1"
            min="0.1"
            value={form.weight}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="reps">횟수</label>
          <input
            id="reps"
            name="reps"
            type="number"
            min="1"
            value={form.reps}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="sets">세트</label>
          <input
            id="sets"
            name="sets"
            type="number"
            min="1"
            value={form.sets}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit" disabled={submitting}>
          {submitting ? '등록 중...' : '등록'}
        </button>
      </form>
      {status && (
        <p role={status.type === 'error' ? 'alert' : 'status'}>{status.message}</p>
      )}
    </section>
  );
}

export default ExerciseLogRegisterPage;
