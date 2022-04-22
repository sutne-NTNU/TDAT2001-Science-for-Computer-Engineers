function res = ElektriskFeltstyrkeFraPunktladning(E, Q, r)
if E == 0
	res = k * abs(Q)/r^2;
elseif Q == 0
	res = E/k*r^2;
elseif r == 0
	res = sqrt(k * abs(Q)/E);
end

