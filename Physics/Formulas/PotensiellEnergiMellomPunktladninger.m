function res = PotensiellEnergiMellomPunktladninger(U, q1, q2, r)
if U == 0
	res = k*q1*q2/r;
elseif q1 == 0
	res = U*r/(k*q2);
elseif q2 == 0
	res = U*r/(k*q1);
elseif r == 0
	res = k*q1*q2/U;
end

