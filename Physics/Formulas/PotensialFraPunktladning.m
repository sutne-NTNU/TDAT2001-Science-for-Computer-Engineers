function res = PotensialFraPunktladning(V, Q, r)
r = abs(r);
if V == 0
	res = k * Q/r;
elseif Q == 0
	res = V*r/k;
elseif r == 0
	res = k * Q/V;
end

