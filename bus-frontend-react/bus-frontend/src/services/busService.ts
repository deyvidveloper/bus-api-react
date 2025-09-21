import type { Bus } from '../types/Bus';

const BASE_URL = 'http://localhost:8080';

const authHeader = {
  Authorization: 'Basic ' + btoa('admin:admin123'),
};

export const fetchBuses = async (): Promise<Bus[]> => {
  const response = await fetch(`${BASE_URL}/bus`, { headers: authHeader });
  if (!response.ok) throw new Error('Error al obtener buses');
  return response.json();
};

export const fetchBusById = async (id: number): Promise<Bus> => {
  const response = await fetch(`${BASE_URL}/bus/${id}`, { headers: authHeader });
  if (!response.ok) throw new Error('Bus no encontrado');
  return response.json();
};